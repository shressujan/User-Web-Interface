package edu.unk.cs406.user.validation;

/**
 * Patterns used for validation in UserEntity.
 * @author Salas
 *
 */
public class ValidationPatterns {
	final public static String NUMBER_PATTERN = "^.*[0-9].*$";
	final public static String LOWERCASE_PATTERN = "^.*[a-z].*$";
	final public static String UPPERCASE_PATTERN = "^.*[A-Z].*$";
	final public static String SYMBOL_PATTERN = "^.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$";
	final public static String EMAIL_PATTERN = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
	final public static String PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[a-z])(?=.*[\\d])(?=.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?])(?!.*\\s).{8,}";
//	final public static String EMAIL_PATTERN ="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
}