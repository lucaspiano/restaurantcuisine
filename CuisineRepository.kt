package repository

import dto.Cuisine
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.File

class CuisineRepository(val fileName : File) {
    //val fileCuisine = File("C:\\Users\\lsab\\Documents\\workspace\\AlphaSightsFood" +
      //      "\\src\\main\\resources\\cuisines.csv")

    fun getCuisineData() : MutableList<Cuisine> {
        val bufferedReaderCuisine: BufferedReader = fileName.bufferedReader()

        val csvParserCuisine = CSVParser(
            bufferedReaderCuisine, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
        );

        var cuisineList : MutableList<Cuisine> = mutableListOf()
        for (csvRecord in csvParserCuisine) {
            val id = csvRecord.get("id")
            val name = csvRecord.get("name")
            var cuisine : Cuisine = Cuisine()
            cuisine.id = id
            cuisine.name = name

            cuisineList.add(cuisine)
        }

        return cuisineList
    }

}