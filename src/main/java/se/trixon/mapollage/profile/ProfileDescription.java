/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.mapollage.profile;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

/**
 *
 * @author Patrik Karlsson
 */
public class ProfileDescription extends ProfileBase {

    public static final String KEY_ALTITUDE = "altitude";
    public static final String KEY_BEARING = "bearing";
    public static final String KEY_COORDINATE = "coordinate";
    public static final String KEY_CUSTOM = "custom";
    public static final String KEY_CUSTOM_VALUE = "customValue";
    public static final String KEY_DATE = "date";
    public static final String KEY_EXTERNAL_FILE = "externalFile";
    public static final String KEY_EXTERNAL_FILE_VALUE = "externalFileValue";
    public static final String KEY_FILENAME = "filename";
    public static final String KEY_PHOTO = "photo";
    private static final String sDefaultCustomValue;

    private boolean mAltitude;
    private boolean mBearing;
    private boolean mCoordinate = true;
    private boolean mCustom;
    private String mCustomValue;
    private boolean mDate = true;
    private boolean mExternalFile;
    private String mExternalFileValue = "description.csv";
    private boolean mFilename = true;
    private boolean mPhoto = true;
    private final Profile mProfile;

    static {
        StringBuilder builder = new StringBuilder();

//        builder.append("<p>").append(DescriptionSegment.PHOTO.toString()).append("</p>\n")
//                .append("<h2>").append(DescriptionSegment.FILENAME.toString()).append("</h2>\n")
//                .append("<p>").append(DescriptionSegment.DATE.toString()).append("</p>\n")
//                .append("<p>").append(DescriptionSegment.COORDINATE.toString()).append(", ").append(DescriptionSegment.ALTITUDE.toString()).append("</p>\n")
//                .append("<p>").append(DescriptionSegment.BEARING.toString()).append("</p>\n");
        builder.append(DescriptionSegment.PHOTO.toHtml())
                .append(DescriptionSegment.FILENAME.toHtml())
                .append(DescriptionSegment.DATE.toHtml())
                .append(DescriptionSegment.COORDINATE.toHtml())
                .append(DescriptionSegment.ALTITUDE.toHtml())
                .append(DescriptionSegment.BEARING.toHtml());

        sDefaultCustomValue = builder.toString();
    }

    public static String getDefaultCustomValue() {
        return sDefaultCustomValue;
    }

    public ProfileDescription(Profile profile, JSONObject json) {
        mProfile = profile;
        mAltitude = getBoolean(json, KEY_ALTITUDE);
        mBearing = getBoolean(json, KEY_BEARING);
        mCoordinate = getBoolean(json, KEY_COORDINATE);
        mCustom = getBoolean(json, KEY_CUSTOM);
        mDate = getBoolean(json, KEY_DATE);
        mExternalFile = getBoolean(json, KEY_EXTERNAL_FILE);
        mFilename = getBoolean(json, KEY_FILENAME);
        mPhoto = getBoolean(json, KEY_PHOTO);

        mCustomValue = (String) json.get(KEY_CUSTOM_VALUE);
        mExternalFileValue = (String) json.get(KEY_EXTERNAL_FILE_VALUE);
    }

    public ProfileDescription(final Profile profile) {
        mProfile = profile;
    }

    public String getCustomValue() {
        if (StringUtils.isBlank(mCustomValue)) {
            return sDefaultCustomValue;
        } else {
            return mCustomValue;
        }
    }

    public String getExternalFileValue() {
        return mExternalFileValue;
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        json.put(KEY_ALTITUDE, mAltitude);
        json.put(KEY_BEARING, mBearing);
        json.put(KEY_COORDINATE, mCoordinate);
        json.put(KEY_CUSTOM, mCustom);
        json.put(KEY_CUSTOM_VALUE, mCustomValue);
        json.put(KEY_DATE, mDate);
        json.put(KEY_EXTERNAL_FILE, mExternalFile);
        json.put(KEY_EXTERNAL_FILE_VALUE, mExternalFileValue);
        json.put(KEY_FILENAME, mFilename);
        json.put(KEY_PHOTO, mPhoto);

        return json;
    }

    public boolean hasAltitude() {
        return mAltitude;
    }

    public boolean hasBearing() {
        return mBearing;
    }

    public boolean hasCoordinate() {
        return mCoordinate;
    }

    public boolean hasDate() {
        return mDate;
    }

    public boolean hasExternalFile() {
        return mExternalFile;
    }

    public boolean hasFilename() {
        return mFilename;
    }

    public boolean hasPhoto() {
        return mPhoto;
    }

    public boolean isCustom() {
        return mCustom;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public void setAltitude(boolean altitude) {
        mAltitude = altitude;
    }

    public void setBearing(boolean bearing) {
        mBearing = bearing;
    }

    public void setCoordinate(boolean coordinate) {
        mCoordinate = coordinate;
    }

    public void setCustom(boolean custom) {
        mCustom = custom;
    }

    public void setCustomValue(String customValue) {
        mCustomValue = customValue;
    }

    public void setDate(boolean date) {
        mDate = date;
    }

    public void setExternalFile(boolean externalFile) {
        mExternalFile = externalFile;
    }

    public void setExternalFileValue(String externalFileValue) {
        mExternalFileValue = externalFileValue;
    }

    public void setFilename(boolean filename) {
        mFilename = filename;
    }

    public void setPhoto(boolean photo) {
        mPhoto = photo;
    }

    @Override
    public String toDebugString() {
        return "ProfileDescription{" + "mProfile=" + mProfile + ", mAltitude=" + mAltitude + ", mBearing=" + mBearing + ", mCoordinate=" + mCoordinate + ", mCustom=" + mCustom + ", mDate=" + mDate + ", mExternalFile=" + mExternalFile + ", mExternalFileValue=" + mExternalFileValue + ", mCustomValue=" + mCustomValue + ", mFilename=" + mFilename + ", mPhoto=" + mPhoto + '}';
    }

    public static enum DescriptionSegment {
        ALTITUDE, BEARING, COORDINATE, DATE, FILENAME, PHOTO;

        @Override
        public String toString() {
            return String.format("+%s", name().toLowerCase());
        }

        public String toHtml() {
            String begTag = "<p>";
            String endTag = "</p>";
            if (this == FILENAME) {
                begTag = "<h2>";
                endTag = "</h2>";

            }
            return String.format("%s%s%s\n", begTag, toString(), endTag);
        }
    }
}