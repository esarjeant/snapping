package com.micromux.snapping;

import com.micromux.snapping.model.About;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Application configuration for SnapPing. This reads and parses the configuration file from
 * the users home directory. If the file does not exist yet then it returns a new configuration.
 */
public class ApplicationConfig {

    List<HostConfig> hostConfigurations;

    public static About getAbout() throws IOException {

        Properties version = new Properties();

        InputStream propReader = ApplicationConfig.class.getResourceAsStream("/version.properties");
        if (propReader != null) {
            version.load(propReader);
        } else {
            throw new FileNotFoundException("Version Not Found");
        }

        About about = new About();
        about.setName(version.getProperty("name"));
        about.setGroup(version.getProperty("group"));
        about.setVersion(version.getProperty("version"));
        about.setCommitId(version.getProperty("git.commit.id"));
        about.setBranchId(version.getProperty("git.branch"));
        about.setCommitTime(version.getProperty("git.commit.time"));

        return about;

    }

    public List<HostConfig> getHostConfigurations() {
        return hostConfigurations;
    }

    public void addHostConfiguration(HostConfig config) {
        this.hostConfigurations.add(config);
    }

    public void removeHostConfiguration(HostConfig config) {
        this.hostConfigurations.remove(config);
    }

}
