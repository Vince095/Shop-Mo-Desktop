package models;

public interface DataSource {
    void getData();

    void getResultData();

    // Failed Message
    String failedResult(int statusCode, String errorMessage);

    // Show Progress View
    void onShowProgress();

    // Hide Progress View
    void onHideProgress();
}
