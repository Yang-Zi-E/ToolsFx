package me.leon.toolsfx.plugin.ext

import me.leon.P1

/**
 * 图像形态学,需要变成二值图 需要指定kernel大小
 *
 * @author Leon
 * @since 2022-12-23 16:48
 * @email deadogone@gmail.com
 */
enum class ImageMorphology : SimpleService {
    ERODE {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().erode(params.parseParams())
    },
    DILATE {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().dilate(params.parseParams())
    },
    OPEN_OP {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().openOp(params.parseParams())
    },
    CLOSE_OP {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().closeOp(params.parseParams())
    },
    GRADIENT {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().gradient(params.parseParams())
    },
    BLACK_HAT {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().blackHat(params.parseParams())
    },
    TOP_HAT {
        override fun process(file: String, params: Map<String, String>) =
            file.autoConvertToBufferImage()!!.binary().topHat(params.parseParams())
    };

    fun Map<String, String>.parseParams() = requireNotNull(this[P1]).ifEmpty { "3" }.toInt()
}
