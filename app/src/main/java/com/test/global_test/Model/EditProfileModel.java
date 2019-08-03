package com.test.global_test.Model;

public class EditProfileModel {

        private Integer id;

        private String name;

        private Object address;

        private Object pincode;

        private Object fax;

        private String mobile;

        private String email;

        private Object birthdate;

        private Object caste;

        private Object originalplace;

        private Object loksabha;

        private Object vidhansabha;

        private Object panchayat;

        private Object businessname;

        private Object officeaddress;

        private Object categoryId;

        private Object celebrity;

        private Object celebrityDetails;

        private Object married;

        private Object image;

        private String userId;

        private Object familyId;

        private String createdAt;

        private String updatedAt;

        public EditProfileModel(){

        }
        public EditProfileModel(String userId,String createdAt,String updatedAt,Object familyId,Object image,Object married,Object celebrityDetails,Object celebrity,
                                Object categoryId,Object officeaddress,Object businessname, Object panchayat,Object vidhansabha,Object loksabha,Object originalplace,
                                Object caste,Object birthdate,Object fax,Object address,String email,String mobile,String name,Integer id){
            super();
            this.address = address;
            this.birthdate = birthdate;
            this.businessname = businessname;
            this.email = email;
            this.mobile = mobile;
            this.name = name;
            this.id = id;
            this.familyId = familyId;
            this.fax = fax;
            this.caste = caste;
            this.originalplace = originalplace;
            this.loksabha = loksabha;
            this.vidhansabha = vidhansabha;
            this.panchayat = panchayat;
            this.officeaddress = officeaddress;
            this.categoryId = categoryId;
            this.celebrity = celebrity;
            this.celebrityDetails = celebrityDetails;
            this.married = married;
            this.image = image;
            this.updatedAt = updatedAt;
            this.createdAt = createdAt;
            this.userId = userId;
        }
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getPincode() {
            return pincode;
        }

        public void setPincode(Object pincode) {
            this.pincode = pincode;
        }

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
            this.fax = fax;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(Object birthdate) {
            this.birthdate = birthdate;
        }

        public Object getCaste() {
            return caste;
        }

        public void setCaste(Object caste) {
            this.caste = caste;
        }

        public Object getOriginalplace() {
            return originalplace;
        }

        public void setOriginalplace(Object originalplace) {
            this.originalplace = originalplace;
        }

        public Object getLoksabha() {
            return loksabha;
        }

        public void setLoksabha(Object loksabha) {
            this.loksabha = loksabha;
        }

        public Object getVidhansabha() {
            return vidhansabha;
        }

        public void setVidhansabha(Object vidhansabha) {
            this.vidhansabha = vidhansabha;
        }

        public Object getPanchayat() {
            return panchayat;
        }

        public void setPanchayat(Object panchayat) {
            this.panchayat = panchayat;
        }

        public Object getBusinessname() {
            return businessname;
        }

        public void setBusinessname(Object businessname) {
            this.businessname = businessname;
        }

        public Object getOfficeaddress() {
            return officeaddress;
        }

        public void setOfficeaddress(Object officeaddress) {
            this.officeaddress = officeaddress;
        }

        public Object getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Object categoryId) {
            this.categoryId = categoryId;
        }

        public Object getCelebrity() {
            return celebrity;
        }

        public void setCelebrity(Object celebrity) {
            this.celebrity = celebrity;
        }

        public Object getCelebrityDetails() {
            return celebrityDetails;
        }

        public void setCelebrityDetails(Object celebrityDetails) {
            this.celebrityDetails = celebrityDetails;
        }

        public Object getMarried() {
            return married;
        }

        public void setMarried(Object married) {
            this.married = married;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getFamilyId() {
            return familyId;
        }

        public void setFamilyId(Object familyId) {
            this.familyId = familyId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

