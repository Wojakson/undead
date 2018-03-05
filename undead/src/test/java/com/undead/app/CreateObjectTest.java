package com.undead.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class CreateObjectTest
{
    @Test
    public void testCreateObject()
    {
     Undead undead = new Undead("Szkielet Wojownik", "Szkielet", 2, "Cmentarz", "Demoralizacja");
     assertNotNull(undead);
    }
}
