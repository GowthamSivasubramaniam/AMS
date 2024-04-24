package com.example.rms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private MarkRepo markRepo;
	

	public StudentServiceImpl(StudentRepository studentRepository, MarkRepo markRepo) {
		super();
		this.studentRepository = studentRepository;
		this.markRepo = markRepo;
	}

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student=StudentMapper.mapToStudent(studentDto);
		List<Mark> Absent=new ArrayList<>();
		for(MarkDto m:studentDto.getAtt()) {
			Mark mark=new Mark(m.getId(),m.getmonth(),m.getdays(),m.getyear());
			mark.setStudent(student);
			Absent.add(mark);
		}
		student.setAttendence(Absent);
		Student savedStudent= studentRepository.save(student);
		return StudentMapper.mapToStudentDto(savedStudent);
	}

	@Override
	public StudentDto getStudentById(Long studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		return StudentMapper.mapToStudentDto(student);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students=studentRepository.findAll();		
		return students.stream().map((student)->StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
	}

	@Override
	public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
		Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		student.setName(updatedStudent.getName());
		student.setRollno(updatedStudent.getRollno());
		student.setEmail(updatedStudent.getEmail());
		List<Mark> marks=student.getAttendence();
		int i=0;
		for(MarkDto m:updatedStudent.getAtt()) {
			marks.get(i).setmonth(m.getmonth());
			marks.get(i).setdays(m.getdays());
			marks.get(i).setyear(m.getyear());
			i++;
		}
		student.setAttendence(marks);
		Student upStudent= studentRepository.save(student);
		return StudentMapper.mapToStudentDto(upStudent);
	}

	@Override
	public void deleteStudent(Long studentId) {
		Student student=studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student is not exist with the given Student ID :"+studentId));
		studentRepository.deleteById(studentId);
	}

	@Override
	public StudentDto getStudentByRollno(String rollno) {
		Student student = studentRepository.findByRollno(rollno).orElseThrow(()->new ResourceNotFoundException("Student is not exist with the given RollNo :"+rollno));
		return StudentMapper.mapToStudentDto(student);
	}
}
