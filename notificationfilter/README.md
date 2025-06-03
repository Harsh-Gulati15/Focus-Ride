# Notification Filter Module for Ride-Hailing Apps

This module provides a reusable notification filtering logic for ride-hailing apps (e.g., Ola, Uber, Rapido) to reduce driver distraction from new ride notifications during ongoing trips.

## Features
- Only allows new ride notifications if:
  - The booking is for a later time (scheduled ride), OR
  - The driver is near the drop-off (e.g., after 80% of the trip or within 1-3 km)
- Easy integration: drop-in Kotlin library/module
- Simple API for use in your app's notification and ride-tracking logic

## Integration Steps
1. Add the `notificationfilter` module to your Android project.
2. Use the provided API to determine if a notification should be shown.
3. Call the logic on ride progress updates and before displaying new ride notifications.

## Example Usage
```kotlin
val filter = NotificationFilter()
val shouldShow = filter.shouldShowRideNotification(
    rideStatus = RideStatus.ONGOING,
    distanceToDropoff = 2.5f, // in km
    totalDistance = 15f, // in km
    isScheduled = false
)
if (shouldShow) {
    // Show notification
} else {
    // Suppress notification
}
```

## API
- `shouldShowRideNotification(rideStatus: RideStatus, distanceToDropoff: Float, totalDistance: Float, isScheduled: Boolean): Boolean`
- Call this function before displaying a new ride notification.

## Testing
- Unit tests are recommended for logic validation (see `src/test`).
- Integration tests can be added to the main app to simulate ride scenarios.


