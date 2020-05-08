package Services;

import POJOs.CardNumbers;

import java.util.List;

public interface ApplicationService {
    List<String> generateNonRepeatingNumbers(CardNumbers cardNumbers);
}
