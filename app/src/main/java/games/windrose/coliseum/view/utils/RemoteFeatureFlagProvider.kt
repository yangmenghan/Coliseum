package games.windrose.coliseum.view.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import games.windrose.coliseum.R
import games.windrose.coliseum.core.util.FeatureFlagProvider
import org.koin.core.annotation.Single

@Single
class RemoteFeatureFlagProvider: FeatureFlagProvider {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val settings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(settings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

    override val shouldShowLogin: Boolean
        get() = remoteConfig.getBoolean("login")
}