package io.davidosemwota.puppy.data

object DataSource {

    fun getAllPups(): List<Pup> =
        listOf(
            Pup(
                "Korgu",
                "German shorthaired pointer",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy_one_mksymb.jpg",
                "Male",
                ""
            ),
            Pup(
                "Shela",
                "dalmatian",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy12_xwnr79.webp",
                "Female",
                ""
            ),
            Pup(
                "Max",
                "Labrador Retriever",
                "https://res.cloudinary.com/sakanade/image/upload/v1614568947/puppy/puppy11_nftwqa.jpg",
                "Male",
                ""
            )
        )
}