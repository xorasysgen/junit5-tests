package com.junit5.app.dto;

import java.util.UUID;

public class Multiverse {

	private UUID universeId;
	private String universeName;
	private String universeType;
	private Boolean humanExistence;
	
	public Boolean getHumanExistence() {
		return humanExistence;
	}

	private Multiverse() {
		  throw new IllegalStateException("Can`t create object from constructor: try using builder");
		 
	}


	private Multiverse(UUID universeId, String universeName, String universeType, Boolean humanExistence) {
		super();
		this.universeId = universeId;
		this.universeName = universeName;
		this.universeType = universeType;
		this.humanExistence = humanExistence;
	}


	public static class MultiverseBuilder{
			private UUID universeId;
			private String universeName;
			private String universeType;
			private Boolean humanExistence;
		
			public MultiverseBuilder makeUUId(UUID uuid) {
				this.universeId=uuid;
				return  this;
			}
			
			public MultiverseBuilder createUniverse(String univ) {
				this.universeName=univ;
				return this;
				
			}
			
			public MultiverseBuilder setUniverseType(String universeType ) {
				this.universeType=universeType;
				return this;
			}
			public MultiverseBuilder isHumanExists(Boolean humanExistence) {
				this.humanExistence=humanExistence;
				return this;
			}
			
		public Multiverse build() {
			return new Multiverse(universeId,universeName,universeType,humanExistence);
		}
		
		
	} 
	
	public UUID getUniverseId() {
		return universeId;
	}
	public String getUniverseName() {
		return universeName;
	}
	public String getUniverseType() {
		return universeType;
	}
	
			
	
}
