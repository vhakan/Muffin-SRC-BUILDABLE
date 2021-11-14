package me.han.muffin.client.utils.math.rotation

import me.han.muffin.client.utils.extensions.kotlin.toRadian
import net.minecraft.util.math.Vec3d
import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.pow

data class Vec2d(var x: Double = 0.0, var y: Double = 0.0) {

    constructor(vec3d: Vec3d) : this(vec3d.x, vec3d.y)

    constructor(vec2d: Vec2d) : this(vec2d.x, vec2d.y)

    fun toRadians() = Vec2d(x.toRadian(), y.toRadian())

    fun length() = hypot(x, y)

    fun lengthSquared() = (this.x.pow(2) + this.y.pow(2))


    fun isReallyCloseTo(other: Vec2d): Boolean {
        return yawIsReallyClose(other) && abs(y - other.y) < 0.01
    }

    fun yawIsReallyClose(other: Vec2d): Boolean {
        val yawDiff = abs(RotationUtils.normalizeAngle(x) - RotationUtils.normalizeAngle(other.x)) // you cant fool me
        return yawDiff < 0.01 || yawDiff > 359.99
    }

    operator fun div(vec2d: Vec2d) = div(vec2d.x, vec2d.y)

    operator fun div(divider: Double) = div(divider, divider)

    fun div(x: Double, y: Double) = Vec2d(this.x / x, this.y / y)


    operator fun times(vec2d: Vec2d) = times(vec2d.x, vec2d.y)

    operator fun times(multiplier: Double) = times(multiplier, multiplier)

    fun times(x: Double, y: Double) = Vec2d(this.x * x, this.y * y)


    operator fun minus(vec2d: Vec2d) = minus(vec2d.x, vec2d.y)

    operator fun minus(sub: Double) = minus(sub, sub)

    fun minus(x: Double, y: Double) = plus(-x, -y)


    operator fun plus(vec2d: Vec2d) = plus(vec2d.x, vec2d.y)

    operator fun plus(add: Double) = plus(add, add)

    fun plus(x: Double, y: Double) = Vec2d(this.x + x, this.y + y)

    fun toVec2f() = Vec2f(x.toFloat(), y.toFloat())

    override fun toString(): String {
        return "Vec2d[${this.x}, ${this.y}]"
    }

    companion object {
        @JvmField
        val ZERO = Vec2d(0.0, 0.0)
    }

}