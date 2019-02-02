package com.sphtech.mobileusage.data.local;

/**
 * Created by Ramakrishna Sunkara on 02/02/19.
 */

public interface PreferencesHelper {

    String getToken();

    void clearToken();

    void saveToken(String token);
}
