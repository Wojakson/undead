package com.undead.app;

import static org.junit.Assert.*;

import com.undeadcrud.domain.Undead;
import org.junit.Test;

public class CreateObjectTest
{
    @Test
    public void testCreateObject()
    {
    Undead undead = new Undead("Szkielet Wojownik","Szkielet", 5,"Cmentarz", "Demoralizacja");
    assertNotNull(undead);
    }
}
