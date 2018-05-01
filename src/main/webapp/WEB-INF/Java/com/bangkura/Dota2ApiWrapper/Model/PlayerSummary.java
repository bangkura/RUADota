package com.bangkura.Dota2ApiWrapper.Model;

public class PlayerSummary {
    private String steamid;
    private int communityvisibilitystate;
    private int profilestate;
    private String personaname;
    private long lastlogoff;
    private String profileurl;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private int personastate;
    private String primaryclanid;
    private long timecreated;
    private int personastateflags;

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public int getCommunityvisibilitystate() {
        return communityvisibilitystate;
    }

    public void setCommunityvisibilitystate(int communityvisibilitystate) {
        this.communityvisibilitystate = communityvisibilitystate;
    }

    public int getProfilestate() {
        return profilestate;
    }

    public void setProfilestate(int profilestate) {
        this.profilestate = profilestate;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public long getLastlogoff() {
        return lastlogoff;
    }

    public void setLastlogoff(long lastlogoff) {
        this.lastlogoff = lastlogoff;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public int getPersonastate() {
        return personastate;
    }

    public void setPersonastate(int personastat) {
        this.personastate = personastat;
    }

    public String getPrimaryclanid() {
        return primaryclanid;
    }

    public void setPrimaryclanid(String primaryclanid) {
        this.primaryclanid = primaryclanid;
    }

    public long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }

    public int getPersonastateflags() {
        return personastateflags;
    }

    public void setPersonastateflags(int personastateflags) {
        this.personastateflags = personastateflags;
    }
}
