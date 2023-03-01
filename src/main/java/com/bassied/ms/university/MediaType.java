package com.bassied.ms.university;

public enum MediaType {

    DOC("application/msword"),
    PDF("application/pdf"),
    TXT("text/plain"),
    JPG("image/jpeg"),
    PNG("image/png"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation");

    public final String value;

    MediaType(String value) {
        this.value = value;
    }

    public static MediaType convert(String mediaTypeValue) {
        for (MediaType mediaType : MediaType.values()) {
            if (mediaType.value.equals(mediaTypeValue))
                return mediaType;
        }
        throw new RuntimeException("unsupported media type");//TODO custom exception
    }

}
