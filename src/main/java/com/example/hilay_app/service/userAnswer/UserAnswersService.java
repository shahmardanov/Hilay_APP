package com.example.hilay_app.service.userAnswer;

import com.example.hilay_app.entity.Answers;
import com.example.hilay_app.entity.UserAnswers;
import com.example.hilay_app.exception.UserAnswerNotFoundException;
import com.example.hilay_app.mapper.UserAnswersMapper;
import com.example.hilay_app.repository.AnswersRepository;
import com.example.hilay_app.repository.UserAnswersRepository;
import com.example.hilay_app.request.create.UserAnswersCreateRequest;
import com.example.hilay_app.response.create.UserAnswersCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAnswersService {

    private final UserAnswersRepository userAnswersRepository;
    private final AnswersRepository answersRepository;

    private final UserAnswersMapper userAnswersMapper;

    public UserAnswersCreateResponse createUserAnswer(UserAnswersCreateRequest request) {
        log.info("ActionLog.createUserAnswer service start");

        UserAnswers userAnswers = userAnswersMapper.toEntity(request);

        if (userAnswers.getIsSkipped()) {
            userAnswers.setFkSelectedAnswerId(null);
        }
            UserAnswers savedUserAnswers = userAnswersRepository.save(userAnswers);

        log.info("ActionLog.createUserAnswer service end");
        return userAnswersMapper.toResponse(savedUserAnswers);
    }

    public String check( UserAnswersCreateRequest request){

        Answers answer=answersRepository.findById(createUserAnswer(request).getFkSelectedAnswerId()).orElseThrow(()-> new UserAnswerNotFoundException(HttpStatus.NOT_FOUND.name(),"User anwer not found"));
        if (answer.getIsCorrect()){
            return "Təbriklər, doğru cavab";
        }
        return "Yanlış cavab";
    }
}
