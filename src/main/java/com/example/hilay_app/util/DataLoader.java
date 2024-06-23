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

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadLevels();
        loadQuestionsAndAnswers();
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
        question1.setFkSubCategoryId(1L); // SubCategory = Oyunlar
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
}
