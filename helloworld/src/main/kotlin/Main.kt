import com.diacht.ktest.FactoryItf
import com.diacht.ktest.caffe.MyCafeFactory

fun seed(): String = "Toki4ri"

fun getSimulationObject(): FactoryItf {
    return MyCafeFactory()
}
