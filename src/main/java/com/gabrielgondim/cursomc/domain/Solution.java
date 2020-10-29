package com.gabrielgondim.cursomc.domain;

public class Solution {
    
    public enum DaysOfWeek {
		MONDAY(1,"Mon"),
		TUESDAY(2,"Tue"),
		WEDNESDAY(3,"Wed"),
		THURSDAY(4,"Thu"),
		FRIDAY(5,"Fri"),
		SATURDAY(6,"Sat"),
		SUNDAY(7,"Sun");

		DaysOfWeek(int id, String description) {
		    this.id = id;
		    this.description = description;
		}

		private int id;
		private String description;

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		public static int getCodeFromDesc(String day) {
			
			for(DaysOfWeek x: DaysOfWeek.values()) {
                
				if(x.description.equals(day)) {
					return x.id;	
				}

			}
			
			throw new IllegalArgumentException("Invalid day: " + day); 	
		}

		public static String getDescFromCode(int day) {

			for(DaysOfWeek x: DaysOfWeek.values()) {
				
				if(x.id == day) {
					return x.description;	
				}
				
			}
			
			throw new IllegalArgumentException("Invalid day: " + day);  	
		}
	}
    
    public String solution(String S, int K) {
        
		int dayS = DaysOfWeek.getCodeFromDesc(S);	
		
		int daysToAdd;
		int dayFinally = 0;

		if (K > 7) {

			daysToAdd = K % 7;			
			dayFinally = dayS + daysToAdd;

			if(dayFinally > 7) {
				dayFinally = dayFinally - 7;
			}

		} else {
			
			dayFinally = dayS + K;
			
			if(dayFinally > 7) {
			    dayFinally = dayFinally - 7;
			}

		}
		
		return DaysOfWeek.getDescFromCode(dayFinally);
    }
}