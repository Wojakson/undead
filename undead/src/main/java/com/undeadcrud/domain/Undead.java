package com.undeadcrud.domain;

package com.undead.app;

public class Undead 
{
    private Long id;
    private String nazwa;
    private String typ;
    private int tier;
    private String lokacja;
    private String zdolnoscSpecjalna;
	/**
	 * @return the nazwa
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * @param nazwa the nazwa to set
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}
	/**
	 * @param typ the typ to set
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}
	/**
	 * @return the tier
	 */
	public int getTier() {
		return tier;
	}
	/**
	 * @param tier the tier to set
	 */
	public void setTier(int tier) {
		this.tier = tier;
	}
	/**
	 * @return the lokacja
	 */
	public String getLokacja() {
		return lokacja;
	}
	/**
	 * @param lokacja the lokacja to set
	 */
	public void setLokacja(String lokacja) {
		this.lokacja = lokacja;
	}
	/**
	 * @return the zdolnoscSpecjalna
	 */
	public String getZdolnoscSpecjalna() {
		return zdolnoscSpecjalna;
	}
	/**
	 * @param zdolnoscSpecjalna the zdolnoscSpecjalna to set
	 */
	public void setZdolnoscSpecjalna(String zdolnoscSpecjalna) {
		this.zdolnoscSpecjalna = zdolnoscSpecjalna;
	}


    // public Undead(String nazwa, String typ, int tier, String lokacja, String zdolnoscSpecjalna) {
    //     this.nazwa = nazwa;
    //     this.typ = typ;
    //     this.tier = tier;
    //     this.lokacja = lokacja;
    //     this.zdolnoscSpecjalna = zdolnoscSpecjalna;   
    // }


}
