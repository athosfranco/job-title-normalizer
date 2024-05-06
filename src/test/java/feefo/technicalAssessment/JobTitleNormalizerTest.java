package feefo.technicalAssessment;

import feefo.technicalAssessment.JobTitleNormalizer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class JobTitleNormalizerTest {

    private List<String> idealTitles = Arrays.asList("Architect", "Software engineer", "Quantity surveyor", "Accountant", "Engineer");
    private JobTitleNormalizer normalizer = new JobTitleNormalizer(idealTitles);

    @Test
    public void testNormalizeJavaEngineer() {
        assertEquals("Engineer", normalizer.normalize("Java Engineer"));
    }

    @Test
    public void testNormalizeCSharpEngineer() {
        assertEquals("Engineer", normalizer.normalize("C# Engineer"));
    }

    @Test
    public void testNormalizeAccountant() {
        assertEquals("Accountant", normalizer.normalize("Accountant"));
    }

    @Test
    public void testNormalizeChiefAccountant() {
        assertEquals("Accountant", normalizer.normalize("Chief Accountant"));
    }

    @Test
    public void testNormalizeArchitect() {
        assertEquals("Architect", normalizer.normalize("Junior Architect"));
    }

    @Test
    public void testNormalizeNullInput() {
        assertThrows(IllegalArgumentException.class, () -> normalizer.normalize(null));
    }

    @Test
    public void testNormalizeEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> normalizer.normalize(""));
    }

    @Test
    public void testNormalizeEmptyIdealTitles() {
        assertThrows(IllegalArgumentException.class, () -> new JobTitleNormalizer(Arrays.asList()));
    }
}
