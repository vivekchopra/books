package com.wrox.begjsp.ch23.football;

import java.util.List;

public interface RosterManager
{
    void releaseResources();
    
    List getTeamsInRoster() throws DataException;
    boolean addNewTeamToRoster(Team newTeam) throws DataException;
    boolean modifyTeamInRoster(Team modifyTeam) throws DataException;
    boolean deleteTeamFromRoster(int teamId) throws DataException;

    List getVenuesInRoster() throws DataException;
    boolean addNewVenueToRoster(Venue venue) throws DataException;
    boolean deleteVenueFromRoster(int venueId) throws DataException;
    boolean modifyVenueInRoster(Venue venue) throws DataException;

    List getFixturesInRoster() throws DataException;
    boolean addNewFixtureToRoster(Fixture fixture) throws DataException;
    boolean deleteFixtureFromRoster(int fixtureId) throws DataException;
    boolean modifyFixtureInRoster(Fixture fixture) throws DataException;

    List getRoundsInRoster() throws DataException;

    Round getRoundById(int id) throws DataException;
    Team  getTeamById(int id) throws DataException;
    Venue getVenueById(int id) throws DataException;
}