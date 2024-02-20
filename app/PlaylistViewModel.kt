class PlaylistViewModel (private val api: PlaylistApi):  ViewModel(){

    private val playlist = MutableStateFlow<PlaylistResponse?>(null)
    val playlist: StateFlow<PlaylistResponse?> = _playlist

    fun fetchPlaylist() {
        viewModelScope.launch {
            try {
                _playlist.value = api.getPlaylist().body()
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }
}