package com.hyuseinlesho.powerlog.service.impl;

import com.hyuseinlesho.powerlog.mapper.ExerciseLogMapper;
import com.hyuseinlesho.powerlog.model.dto.ExerciseLogGraphDto;
import com.hyuseinlesho.powerlog.model.entity.ExerciseLog;
import com.hyuseinlesho.powerlog.repository.ExerciseLogRepository;
import com.hyuseinlesho.powerlog.service.ExerciseLogService;
import com.hyuseinlesho.powerlog.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {
    private final ExerciseLogRepository exerciseLogRepository;
    private final UserService userService;

    public ExerciseLogServiceImpl(ExerciseLogRepository exerciseLogRepository, UserService userService) {
        this.exerciseLogRepository = exerciseLogRepository;
        this.userService = userService;
    }

    @Override
    public List<ExerciseLogGraphDto> getExerciseLogs(String exerciseName, LocalDate startDate, LocalDate endDate) {
        List<ExerciseLog> exerciseLogs = exerciseLogRepository.findExerciseLogsByExerciseNameAndDateRange(
                exerciseName, startDate, endDate, userService.getCurrentUser().getId()
        );

        return exerciseLogs.stream()
                .map(ExerciseLogMapper.INSTANCE::mapToExerciseLogGraphDto)
                .toList();
    }
}