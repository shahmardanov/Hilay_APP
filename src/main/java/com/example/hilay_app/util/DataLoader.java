package com.example.hilay_app.util;

import com.example.hilay_app.entity.*;
import com.example.hilay_app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final QuestionsLevelRepository questionsLevelRepository;
    private final QuestionsRepository questionsRepository;
    private final AnswersRepository answersRepository;
    private final CardRepository cardRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadLevels();
        loadQuestionsAndAnswers();
        loadCards();
    }

    private void loadCategories() {
        // Added Main Categories
        MainCategory kursCategory = new MainCategory();
        kursCategory.setMainCategoryName("Kurs");
        mainCategoryRepository.save(kursCategory);

        MainCategory elanlarCategory = new MainCategory();
        elanlarCategory.setMainCategoryName("Elanlar");
        mainCategoryRepository.save(elanlarCategory);

        // Added Sub Categories
        SubCategory oyunlarSubCategory = new SubCategory();
        oyunlarSubCategory.setSubCategoryName("Oyunlar");
        oyunlarSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(oyunlarSubCategory);

        SubCategory proqramlasdirmaSubCategory = new SubCategory();
        proqramlasdirmaSubCategory.setSubCategoryName("Proqramlaşdırma");
        proqramlasdirmaSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(proqramlasdirmaSubCategory);

        SubCategory iqSubCategory = new SubCategory();
        iqSubCategory.setSubCategoryName("Iq");
        iqSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(iqSubCategory);

        SubCategory ingilisDiliSubCategory = new SubCategory();
        ingilisDiliSubCategory.setSubCategoryName("Ingilis Dili");
        ingilisDiliSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(ingilisDiliSubCategory);

        SubCategory dizaynSubCategory = new SubCategory();
        dizaynSubCategory.setSubCategoryName("Dizayn");
        dizaynSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(dizaynSubCategory);

        SubCategory robotexnikaSubCategory = new SubCategory();
        robotexnikaSubCategory.setSubCategoryName("Robotexnika");
        robotexnikaSubCategory.setFkMainCategoryId(elanlarCategory.getMainCategoryId());
        subCategoryRepository.save(robotexnikaSubCategory);

        SubCategory itIxtisasiProgrami = new SubCategory();
        itIxtisasiProgrami.setSubCategoryName("IT ixtisasi programi 2024-2025");
        itIxtisasiProgrami.setFkMainCategoryId(kursCategory.getMainCategoryId());
        subCategoryRepository.save(itIxtisasiProgrami);

    }

    private void loadLevels() {
        // added Questions Levels
        QuestionsLevel easyLevel = new QuestionsLevel();
        easyLevel.setDifficulty("easy");
        questionsLevelRepository.save(easyLevel);

        QuestionsLevel mediumLevel = new QuestionsLevel();
        mediumLevel.setDifficulty("medium");
        questionsLevelRepository.save(mediumLevel);

        QuestionsLevel hardLevel = new QuestionsLevel();
        hardLevel.setDifficulty("hard");
        questionsLevelRepository.save(hardLevel);
    }

    private void loadQuestionsAndAnswers() {
        // Added Question and Answers

        // Example Question
        Questions question1 = new Questions();
        question1.setQuestionText("What is 2 + 2?");
        question1.setFkLevelId(1L); // easy level
        question1.setFkCardId(1L); // card = "Modul 1 Ikt-ye Giris"
        questionsRepository.save(question1);

        Answers answer1 = new Answers();
        answer1.setFkQuestionId(question1.getQuestionId());
        answer1.setAnswerText("4");
        answer1.setIsCorrect(true);
        answersRepository.save(answer1);

        Answers answer2 = new Answers();
        answer2.setFkQuestionId(question1.getQuestionId());
        answer2.setAnswerText("3");
        answer2.setIsCorrect(false);
        answersRepository.save(answer2);

        Answers answer3 = new Answers();
        answer3.setFkQuestionId(question1.getQuestionId());
        answer3.setAnswerText("5");
        answer3.setIsCorrect(false);
        answersRepository.save(answer3);

        Answers answer4 = new Answers();
        answer4.setFkQuestionId(question1.getQuestionId());
        answer4.setAnswerText("6");
        answer4.setIsCorrect(false);
        answersRepository.save(answer4);

    }

    private void loadCards(){
        Card card = new Card(); //elanlar
        card.setTitle("Usaqlar ucun IT ixtisasi");
        card.setContent("text");
        card.setImage("image.png");
        card.setFkSubCategoryId(1L);
        cardRepository.save(card);

        Card card1 = new Card(); //elanlar
        card1.setTitle("Usaqlar ucun Karyera");
        card1.setContent("text");
        card1.setImage("image1.png");
        card1.setFkSubCategoryId(1L);
        cardRepository.save(card1);

        Card card2 = new Card(); //elanlar
        card2.setTitle("Usaqlar ucun Proqram");
        card2.setContent("text");
        card2.setImage("image2.png");
        card2.setFkSubCategoryId(1L);
        cardRepository.save(card2);

        Card card3 = new Card(); //kurs
        card3.setTitle("Modul 1 Ikt-ye Giris");
        card3.setContent("text");
        card3.setImage("image-modul.png");
        card3.setFkSubCategoryId(7L);
        cardRepository.save(card3);

        Card card4 = new Card(); //kurs
        card4.setTitle("Modul 2 Komputerin qurulusu");
        card4.setContent("text");
        card4.setImage("image-modul-2.png");
        card4.setFkSubCategoryId(7L);
        cardRepository.save(card4);

        Card card5 = new Card(); //kurs
        card5.setTitle("Modul 3 Metn Redaktoru");
        card5.setContent("text");
        card5.setImage("image-modul-3.png");
        card5.setFkSubCategoryId(7L);
        cardRepository.save(card5);

    }
}
