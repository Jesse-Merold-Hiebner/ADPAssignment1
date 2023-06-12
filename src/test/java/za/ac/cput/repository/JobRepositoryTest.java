package za.ac.cput.repository;
/*
 * User.java
 * Entity for the JobRepository.java
 * Author: Tumelo Mzaca (206006330)
 * Date: 28/03/2023
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Job;
import za.ac.cput.factory.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class JobRepositoryTest {

    private static JobRepository repository = JobRepository.getRepository();
    private static Job job = JobFactory.createJob(1, "Cashier", 8600);

    @Test
    void a_create()
    {
        Job created = repository.create(job);
        assertEquals(job.getJob_id(), created.getJob_id());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read()
    {
        Job read = repository.read(job.getJob_id());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update()
    {
        Job updated = new Job.Builder().copy(job).setJob_id(2)
                .setJob_id(2)
                .setJob_title("Assistant store manage")
                .setWage(15600)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete()
    {
        boolean success = repository.delete(job.getJob_id());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll()
    {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}