package com.example.topjuantech_ojt;

public interface ActivityCallback {
    void onEditTextChange(String _adminID, String _establishmentType);
    String getAdminID();
    String getEstablishmentType();
}
