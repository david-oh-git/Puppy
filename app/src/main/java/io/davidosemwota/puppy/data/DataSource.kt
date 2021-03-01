package io.davidosemwota.puppy.data

object DataSource {

    val puppies = getAllPups()

    fun getPuppy(id: Int): Pup? = puppies.find { it.id == id }

    private fun getAllPups(): List<Pup> =
        listOf(
            Pup(
                22,
                "Korgu",
                "German shorthaired pointer",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy_one_mksymb.jpg",
                "Male",
                ""
            ),
            Pup(
                14,
                "Shela",
                "dalmatian",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy12_xwnr79.webp",
                "Female",
                ""
            ),
            Pup(
                39,
                "Max",
                "Labrador Retriever",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy11_nftwqa.jpg",
                "Male",
                ""
            )
        )
}