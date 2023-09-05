import io.ktor.util.date.GMTDate
import org.junit.Test
import kotlin.test.assertEquals

class Utils {


    @Test
    fun testDate(){
        val date = GMTDate()
        assertEquals("as","${date.dayOfMonth}/${date.month}/${date.year} ${date.hours}:${date.minutes}")
    }

}