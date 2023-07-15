import java.io.File
import java.io.InputStream

fun main() {
    // csv 파일에서 list로 받은 데이터를 array로 mapping
    val path = System.getProperty("user.dir") + "/src/main/resources"
    var fileName = "서울.csv"
    var file = File("$path", "$fileName")
    var inputStream: InputStream = file.inputStream()
    var precipitationList = readCsv(inputStream)
    val 서울 = arrayOf(precipitationList.map { it.yearMonth }.toTypedArray(), precipitationList.map { it.avgTemperatures }.toTypedArray(),
        precipitationList.map { it.avgHighTemperature }.toTypedArray(), precipitationList.map { it.avgMinimumTemperature }.toTypedArray(), precipitationList.map { it.avgPrecipitation }.toTypedArray())

    fileName = "부산.csv"
    file = File("$path", "$fileName")
    inputStream = file.inputStream()
    precipitationList = readCsv(inputStream)
    val 부산 = arrayOf(precipitationList.map { it.yearMonth }.toTypedArray(), precipitationList.map { it.avgTemperatures }.toTypedArray(),
        precipitationList.map { it.avgHighTemperature }.toTypedArray(), precipitationList.map { it.avgMinimumTemperature }.toTypedArray(), precipitationList.map { it.avgPrecipitation }.toTypedArray())

    fileName = "대구.csv"
    file = File("$path", "$fileName")
    inputStream = file.inputStream()
    precipitationList = readCsv(inputStream)
    val 대구 = arrayOf(precipitationList.map { it.yearMonth }.toTypedArray(), precipitationList.map { it.avgTemperatures }.toTypedArray(),
        precipitationList.map { it.avgHighTemperature }.toTypedArray(), precipitationList.map { it.avgMinimumTemperature }.toTypedArray(), precipitationList.map { it.avgPrecipitation }.toTypedArray())

    fileName = "광주.csv"
    file = File("$path", "$fileName")
    inputStream = file.inputStream()
    precipitationList = readCsv(inputStream)
    val 광주 = arrayOf(precipitationList.map { it.yearMonth }.toTypedArray(), precipitationList.map { it.avgTemperatures }.toTypedArray(),
        precipitationList.map { it.avgHighTemperature }.toTypedArray(), precipitationList.map { it.avgMinimumTemperature }.toTypedArray(), precipitationList.map { it.avgPrecipitation }.toTypedArray())

    // 도시의 월간 강수량 검색
    print("월간 강수량을 알고싶은 도시명: ")
    val city = readln().trim()
    val dateIndex = 0
    val precipIndex = 4
    when {
        city == "서울" -> {
            for (item in 0..서울[dateIndex].size - 1) println("${서울[dateIndex][item]}    ${서울[precipIndex][item]}")
        }
        city == "부산" -> {
            for (item in 0..부산[dateIndex].size - 1) println("${부산[dateIndex][item]}    ${부산[precipIndex][item]}")
        }
        city == "대구" -> {
            for (item in 0..대구[dateIndex].size - 1) println("${대구[dateIndex][item]}    ${대구[precipIndex][item]}")
        }
        city == "광주" -> {
            for (item in 0..광주[dateIndex].size - 1) println("${광주[dateIndex][item]}    ${광주[precipIndex][item]}")
        }
        else -> {
            println("몰?루")
        }
    }

    /* 월간 강수량이 가장 높은 월과 도시 출력
       Array는 그냥 대입하면 Reference를 복사하므로 원본 값이 수정되어 버린다.
       따라서 copyOf() 메서드를 사용하여 Value를 복사하여 사용한다.
    */
    val 임시서울 = 서울[precipIndex].copyOf()
    val 임시부산 = 부산[precipIndex].copyOf()
    val 임시대구 = 대구[precipIndex].copyOf()
    val 임시광주 = 광주[precipIndex].copyOf()

    임시서울.sort(); 임시부산.sort(); 임시대구.sort(); 임시광주.sort()

    // Type이 Comparable<*>으로 나오므로 as 키워드를 이용하여 Type Conversion 해준다.
    val 최대서울강수량 = 임시서울[임시서울.lastIndex] as Double
    val 최대부산강수량 = 임시부산[임시부산.lastIndex] as Double
    val 최대대구강수량 = 임시대구[임시대구.lastIndex] as Double
    val 최대광주강수량 = 임시광주[임시광주.lastIndex] as Double

    var maxCity = "서울"
    var maxValue = 최대서울강수량
    if (maxValue < 최대부산강수량) {
        maxCity = "부산"
        maxValue = 최대부산강수량
    }
    if (maxValue < 최대대구강수량) {
        maxCity = "대구"
        maxValue = 최대대구강수량
    }
    if (maxValue < 최대광주강수량) {
        maxCity = "광주"
        maxValue = 최대광주강수량
    }

    when {
        maxCity == "서울" -> {
            val maxIndex = 서울[precipIndex].indexOf(maxValue)
            print("월간 강수량이 가장 높은 월과 도시: ")
            println("서울    ${서울[dateIndex][maxIndex]}    ${서울[precipIndex][maxIndex]}")
        }
        maxCity == "부산" -> {
            val maxIndex = 부산[precipIndex].indexOf(maxValue)
            print("월간 강수량이 가장 높은 월과 도시: ")
            println("부산    ${부산[dateIndex][maxIndex]}    ${부산[precipIndex][maxIndex]}")
        }
        maxCity == "대구" -> {
            val maxIndex = 대구[precipIndex].indexOf(maxValue)
            print("월간 강수량이 가장 높은 월과 도시: ")
            println("대구    ${대구[dateIndex][maxIndex]}    ${대구[precipIndex][maxIndex]}")
        }
        maxCity == "광주" -> {
            val maxIndex = 광주[precipIndex].indexOf(maxValue)
            print("월간 강수량이 가장 높은 월과 도시: ")
            println("광주    ${광주[dateIndex][maxIndex]}    ${광주[precipIndex][maxIndex]}")
        }
        else -> {
            println("아?루")
        }
    }

}

data class Precipitation(
    val yearMonth: String,
    val avgTemperatures: Double,
    val avgHighTemperature: Double,
    val avgMinimumTemperature: Double,
    val avgPrecipitation: Double
)

fun readCsv(inputStream: InputStream): List<Precipitation> {
    val reader = inputStream.bufferedReader()
//    val header = reader.readLine()
    return reader.lineSequence()
        .filter { it.isNotBlank() }
        .map {
            val (yearMonth, avgTemperatures, avgHighTemperature, avgMinimumTemperature, avgPrecipitation) = it.split(',', ignoreCase = false, limit = 5)
            Precipitation(yearMonth.trim(), avgTemperatures.trim().toDouble(),
                avgHighTemperature.trim().toDouble(), avgMinimumTemperature.trim().toDouble(), avgPrecipitation.trim().toDouble())
        }.toList()
}