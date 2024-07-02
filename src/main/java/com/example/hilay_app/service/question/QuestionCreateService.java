package com.example.hilay_app.service.question;

import com.example.hilay_app.entity.Image;
import com.example.hilay_app.entity.Questions;
import com.example.hilay_app.repository.ImageRepository;
import com.example.hilay_app.repository.QuestionsRepository;
import com.example.hilay_app.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class QuestionCreateService {

    private final ImageService imageService;
    private final ImageRepository imageRepository;
    private final QuestionsRepository questionsRepository;

    public String createQuestion(String questionText, Long fkLevelId, Long fkCardId, MultipartFile file) throws IOException {
        Long fkImageId = null;
        if (file != null && !file.isEmpty()) {
            String fileDownloadUri = imageService.storeFile(file);
            Image image = new Image();
            image.setFileName(file.getOriginalFilename());
            image.setFilePath(fileDownloadUri);
            imageRepository.save(image);
            fkImageId = image.getId();
        }

        Questions question = new Questions();
        question.setQuestionText(questionText);
        question.setFkImageId(fkImageId);
        question.setFkLevelId(fkLevelId);
        question.setFkCardId(fkCardId);
        questionsRepository.save(question);

        return "Question created successfully";
    }
}
