package com.undeadTests.domain;

import org.junit.Before;
import org.junit.Test;
import java.lang.Long.com.undeadcrud.domain.Undead;
import com.undeadcrud.repository.UndeadRepository;
import com.undeadcrud.repository.UndeadRepositoryFactory;

import static org.junit.Assert.*;

public class UndeadTest {

    UndeadRepository undeadRepository;

    @Test
    public void isZombie() {
        Undead zombie = new Undead();
        assertNotNull(zombie);
    }

    @Test
    public void getById(){
        Long idToFind = (long) 1;
        assertNotNull(undeadRepository.getById(idToFind));
    }

    @Test
    public void addUndead(){
        Undead zombie = new Undead();
        zombie.setId((long) 1);
        zombie.setType("Zgnilec");
        undeadRepository.addUndead(zombie);
        assertNotNull(undeadRepository.getById(zombie.getId()));

    }

    @Test
    public void deleteUndead(){
        Undead zombie = undeadRepository.getById((long) 1);
        undeadRepository.deleteUndead(zombie);
        if (undeadRepository.getAll().size() > 0){
            assertNotNull(undeadRepository.getAll());
        }else {
            assertNull(undeadRepository.getById(zombie.getId()));
        }
    }

    @Test
    public void updateUndead(){
        Undead wywloka = new Undead();
        wywloka.setId((long) 1);
        wywloka.setType("wywloka");
        Long zombieToUpdate = (long)1;
        undeadRepository.updateUndead(zombieToUpdate, wywloka);
        assertEquals(undeadRepository.getById(zombieToUpdate).getType(), wywloka.getType());

        for(Undead undead : undeadRepository.getAll()){
            if(wywloka.getId().equals(zombieToUpdate)) {
                assertNotEquals(undead.getType(), wywloka.getType());
            }
        }
    }

    @Test
    public void getAll(){
    assertNotNull(undeadRepository.getAll());
    }

    @Before
    public void initRepository(){
        undeadRepository = UndeadRepositoryFactory.getInstance();
        Undead szwedacz = new Undead();
        Undead ghoul = new Undead();
        Undead ozywieniec = new Undead();
        Undead lisz = new Undead();

        szwedacz.setId((long) 1);
        szwedacz.setType("Szwedacz");

        ghoul.setId((long) 2);
        ghoul.setType("Ghoul");

        ozywieniec.setId((long) 3);
        ozywieniec.setType("Ozywieniec");

        lisz.setId((long) 4);
        lisz.setType("Lisz");

        undeadRepository.addUndead(szwedacz);
        undeadRepository.addUndead(ghoul);
        undeadRepository.addUndead(ozywieniec);
        undeadRepository.addUndead(lisz);
    }
}