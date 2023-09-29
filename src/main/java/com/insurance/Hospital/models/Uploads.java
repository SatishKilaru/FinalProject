package com.insurance.Hospital.models;

public class Uploads {

	int uploadId;
	int reUploadId;
	int claimId;
	String data;
	String type;

	public int getReUploadId() {
		return reUploadId;
	}

	public void setReUploadId(int reUploadId) {
		this.reUploadId = reUploadId;
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
