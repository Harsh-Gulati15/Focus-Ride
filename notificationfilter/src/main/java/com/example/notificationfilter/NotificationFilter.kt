package com.example.notificationfilter

/**
 * NotificationFilter provides logic to determine whether a new ride notification
 * should be shown to the driver based on ride progress and type.
 */
class NotificationFilter {
    /**
     * @param rideStatus The current status of the ride (ONGOING, IDLE, etc.)
     * @param distanceToDropoff Distance in km from current location to drop-off
     * @param totalDistance Total trip distance in km
     * @param isScheduled Whether the new ride is scheduled for later (not immediate)
     * @param thresholdPercent The percent of ride after which notifications are allowed (default 80%)
     * @param proximityKm The proximity in km to drop-off within which notifications are allowed (default 3 km)
     * @return true if notification should be shown, false otherwise
     */
    fun shouldShowRideNotification(
        rideStatus: RideStatus,
        distanceToDropoff: Float,
        totalDistance: Float,
        isScheduled: Boolean,
        thresholdPercent: Int = 80,
        proximityKm: Float = 3f
    ): Boolean {
        if (isScheduled) return true
        if (rideStatus != RideStatus.ONGOING) return true
        if (totalDistance <= 0f) return false
        val percentCompleted = ((totalDistance - distanceToDropoff) / totalDistance) * 100
        return percentCompleted >= thresholdPercent || distanceToDropoff <= proximityKm
    }
}

enum class RideStatus {
    ONGOING, IDLE, COMPLETED, CANCELLED
}
