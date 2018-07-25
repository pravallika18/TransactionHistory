/*
 * Copyright (C) 2018, Roche.
 * All Rights Reserved. No use, copying or distribution
 * of this work may be made except in accordance with a
 * valid license agreement from Roche. This notice
 * must be included on all copies, modifications and
 * derivatives of this work.
 *
 */
package com.example.demo.aspect;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class TranscationDomain implements Serializable {
	@Id
	private String id;
	private String serviceName;
	private String actionName;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TranscationDomain [id=" + id + ", status=" + status + "]";
	}

	
}
