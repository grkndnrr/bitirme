package gurkan.doner.myapplication

class PhotoHolder {
    private val photos = ArrayList<String>()

    fun addPhoto(photo: String) {
        photos.add(photo)
    }

    fun getPhotos(): List<String> {
        return photos
    }
}
