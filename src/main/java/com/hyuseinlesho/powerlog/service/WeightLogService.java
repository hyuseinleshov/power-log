package com.hyuseinlesho.powerlog.service;

import com.hyuseinlesho.powerlog.model.dto.CreateWeightLogDto;
import com.hyuseinlesho.powerlog.model.dto.UpdateWeightLogDto;
import com.hyuseinlesho.powerlog.model.dto.WeightLogDto;
import com.hyuseinlesho.powerlog.model.entity.WeightLog;

import java.util.List;

public interface WeightLogService {
    List<WeightLogDto> findAllWeightLogs();

    WeightLog createWeightLog(CreateWeightLogDto weightLogDto);

    WeightLog updateWeightLog(Long id, UpdateWeightLogDto weightLogDto);

    void deleteWeightLog(Long id);
}