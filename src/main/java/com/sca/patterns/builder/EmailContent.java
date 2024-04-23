package com.sca.patterns.builder;

public class EmailContent {

    private String headerNote;
    private String complaintId;
    private boolean lpaContent;
    private String ticketStatus;
    private String priority;
    private String complaintType;
    private String complaintDescription;
    private String creationDate;

    public String getHeaderNote() {
        return headerNote;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public boolean isLpaContent() {
        return lpaContent;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public String getPriority() {
        return priority;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    private EmailContent(EmailContentBuilder builder) {
        this.headerNote = builder.headerNote;
        this.complaintId = builder.complaintId;
        this.lpaContent = builder.lpaContent;
        this.ticketStatus = builder.ticketStatus;
        this.priority = builder.priority;
        this.complaintDescription = builder.complaintDescription;
        this.complaintType = builder.complaintType;
        this.creationDate = builder.creationDate;
    }

    @Override
    public String toString() {
        return "EmailContent{" +
                "headerNote='" + headerNote + '\'' +
                ", complaintId='" + complaintId + '\'' +
                ", lpaContent=" + lpaContent +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", priority='" + priority + '\'' +
                ", complaintType='" + complaintType + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    public static class EmailContentBuilder {
        protected String headerNote;
        protected String complaintId;
        protected boolean lpaContent;
        protected String ticketStatus;
        protected String priority;
        protected String complaintDescription;
        protected String complaintType;
        protected String creationDate;

        public EmailContentBuilder headerNote(String headerNote) {
            this.headerNote = headerNote;
            return this;
        }

        public EmailContentBuilder complaintId(String complaintId) {
            this.complaintId = complaintId;
            return this;
        }

        public EmailContentBuilder lpaContent(boolean lpaContent) {
            this.lpaContent = lpaContent;
            return this;
        }

        public EmailContentBuilder ticketStatus(String ticketStatus) {
            this.ticketStatus = ticketStatus;
            return this;
        }

        public EmailContentBuilder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public EmailContentBuilder complaintDescription(String complaintDescription) {
            this.complaintDescription = complaintDescription;
            return this;
        }

        public EmailContentBuilder complaintType(String complaintType) {
            this.complaintType = complaintType;
            return this;
        }

        public EmailContentBuilder creationDate(String creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public EmailContent build() {
            return new EmailContent(this);
        }
    }
}
