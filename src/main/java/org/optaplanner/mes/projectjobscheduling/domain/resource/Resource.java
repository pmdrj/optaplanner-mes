/*
 * Copyright 2010 JBoss Inc
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

package org.optaplanner.mes.projectjobscheduling.domain.resource;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.mes.common.domain.AbstractPersistable;
import org.optaplanner.mes.projectjobscheduling.domain.Allocation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamInclude;

@SuppressWarnings("serial")
@XStreamAlias("PjsResource")
@XStreamInclude({ GlobalResource.class, LocalResource.class })
public abstract class Resource extends AbstractPersistable {

	private int capacity;
	private int mesMachineId;
	private String mesMachineNr;
	private List<Allocation> allocationList;

	public String getMesMachineNr() {
		return mesMachineNr;
	}

	public void setMesMachineNr(String mesMachineNr) {
		this.mesMachineNr = mesMachineNr;
	}

	public int getMesMachineId() {
		return mesMachineId;
	}

	public void setMesMachineId(int mesMachineId) {
		this.mesMachineId = mesMachineId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Allocation> getAllocationList() {
		return allocationList;
	}

	public void setAllocationList(List<Allocation> allocationList) {
		this.allocationList = new ArrayList<Allocation>();
	}

	// ************************************************************************
	// Complex methods
	// ************************************************************************

	public abstract boolean isRenewable();

	@Override
	public String toString() {
		return "[" + mesMachineNr + "]";
	}

}
