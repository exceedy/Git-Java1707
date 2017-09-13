package com.situ.student.pojo;

public class BanjiCoures {
		private Integer banjiId;
		private Integer couresId;
		private String banjiName;
		private String couresName;
		
		
		
		
		
		public BanjiCoures(String banjiName, String couresName) {
			super();
			this.banjiName = banjiName;
			this.couresName = couresName;
		}
		public BanjiCoures(Integer banjiId, Integer couresId) {
			super();
			this.banjiId = banjiId;
			this.couresId = couresId;
		}
		public BanjiCoures(Integer banjiId, Integer couresId, String banjiName, String couresName) {
			super();
			this.banjiId = banjiId;
			this.couresId = couresId;
			this.banjiName = banjiName;
			this.couresName = couresName;
		}
		public Integer getBanjiId() {
			return banjiId;
		}
		public void setBanjiId(Integer banjiId) {
			this.banjiId = banjiId;
		}
		public Integer getCouresId() {
			return couresId;
		}
		public void setCouresId(Integer couresId) {
			this.couresId = couresId;
		}
		public String getBanjiName() {
			return banjiName;
		}
		public void setBanjiName(String banjiName) {
			this.banjiName = banjiName;
		}
		public String getCouresName() {
			return couresName;
		}
		public void setCouresName(String couresName) {
			this.couresName = couresName;
		}
		
		
		
}
