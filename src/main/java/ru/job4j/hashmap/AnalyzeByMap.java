package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects == 0 ? 0D : (double) totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double average = pupil.subjects().isEmpty() ? 0D : (double) totalScore / pupil.subjects().size();
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotalScores = new HashMap<>();
        Map<String, Integer> subjectCounts = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotalScores.merge(subject.name(), subject.score(), Integer::sum);
                subjectCounts.merge(subject.name(), 1, Integer::sum);
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectTotalScores.entrySet()) {
            String subjectName = entry.getKey();
            double average = (double) entry.getValue() / subjectCounts.get(subjectName);
            result.add(new Label(subjectName, average));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        int maxScore = 0;
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (totalScore > maxScore) {
                maxScore = totalScore;
                best = new Label(pupil.name(), totalScore);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotalScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotalScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        String bestSubject = null;
        int maxScore = 0;

        for (Map.Entry<String, Integer> entry : subjectTotalScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                bestSubject = entry.getKey();
            }
        }

        return bestSubject == null ? null : new Label(bestSubject, maxScore);
    }

}
