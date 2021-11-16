package utils

class MessageUtils {
    companion object Message{
        val valueRestaurantNameSearchResult : String =
            "Listing all places that match your search criteria based on the restaurant name: "

        val valueRestaurantCustomerRatingSearchResult : String =
            "Listing all places that match your search criteria based on the restaurant name + customer rating: "

        val valueRestaurantDistanceSearch : String =
            "Listing all places that match your search criteria based on the restaurant name + " +
                    "customer rating + distance: "

        val valueRestaurantPriceSearch : String =
            "Listing all places that match your search criteria based on the restaurant name + " +
                    "customer rating + distance + price = "

        val valueRestaurantFinalSearch : String =
            "Listing all available places based on your search criteria."
    }
}