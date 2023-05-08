package ch.progetto152.utility;


import ch.progetto152.entity.LocationEntity;
import ch.progetto152.entity.UserEntity;
import ch.progetto152.entity.WaypointsEntity;
import ch.progetto152.entity.WaypointsVisitedEntity;


// This class is used to check if the data received from the client is valid
public class ErrorChecking {

    public boolean checkUser(UserEntity user){
        return user != null &&
                isNotEmpty(user.getUsername()) &&
                isNotEmpty(user.getPassword());
    }

    public boolean checkLocation(LocationEntity location){
        return location != null &&
                isNotEmpty(location.getLocation()) &&
                isNotEmpty(location.getRegion()) &&
                isNotEmpty(String.valueOf(location.getLat())) &&
                isNotEmpty(String.valueOf(location.getLon()));
    }

    public boolean checkWaypoint(WaypointsEntity waypoint){
        return waypoint != null &&
                isNotEmpty(waypoint.getLocationName()) &&
                isNotEmpty(waypoint.getDescription()) &&
                isNotEmpty(waypoint.getImg()) &&
                isNotEmpty(String.valueOf(waypoint.getLat())) &&
                isNotEmpty(String.valueOf(waypoint.getLon()));
    }

    public boolean checkWaypointVisited(WaypointsVisitedEntity waypointsVisited){
        return waypointsVisited != null &&
                isNotEmpty(String.valueOf(waypointsVisited.getWaypointId())) &&
                isNotEmpty(String.valueOf(waypointsVisited.getUserId()));
    }

    public boolean isNotEmpty(String string){
        return string != null && !string.trim().isEmpty();
    }
}
