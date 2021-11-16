package service

import dto.Cuisine
import dto.Restaurant
import repository.CuisineRepository
import repository.RestaurantRepository
import java.io.File

class FoodService {

    private val fileCuisine = File("C:\\Users\\lsab\\Documents\\workspace" +
            "\\restaurantcuisine\\src\\main\\resources\\cuisines.csv")

    private val fileRestaurant = File("C:\\Users\\lsab\\Documents\\workspace" +
            "\\restaurantcuisine\\src\\main\\resources\\restaurants.csv")

    fun getCuisinesService() : MutableList<Cuisine> {
        val cuisineRepository : CuisineRepository = CuisineRepository(fileCuisine)

        return cuisineRepository.getCuisineData()
    }

    fun getRestaurantService() : MutableList<Restaurant> {
       val restaurantRepository : RestaurantRepository = RestaurantRepository(fileRestaurant)

        val getAllCuisines = getCuisinesService()

        val getAllRestaurants = restaurantRepository.getRestaurantData()

        for (item in getAllRestaurants) {
            for (cuisineId in getAllCuisines) {
                if (cuisineId.id.equals(item.cuisineId)) {
                }
            }
        }

        return restaurantRepository.getRestaurantData()
    }

}