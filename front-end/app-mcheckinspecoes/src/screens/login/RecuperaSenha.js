import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Dimensions, Alert } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

const PasswordRecoveryScreen = () => {
  const [email, setEmail] = useState('');
  const [isEmailSent, setIsEmailSent] = useState(false);

  const handlePasswordRecovery = () => {
    // Verifica se o campo de email está vazio
    if (email.trim() === '') {
      Alert.alert('Erro', 'Por favor, digite um endereço de e-mail.');
      return;
    }

    // Verifica se o email é válido usando expressões regulares
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      Alert.alert('Erro', 'Por favor, digite um endereço de e-mail válido.');
      return;
    }

    // Lógica para enviar o e-mail de recuperação de senha
    // Você pode chamar uma API ou implementar a lógica adequada aqui

    // Simulação de envio de e-mail
    setTimeout(() => {
      setIsEmailSent(true);
    }, 1);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Recuperação de Senha</Text>
      {!isEmailSent ? (
        <View style={styles.formContainer}>
          <Text style={styles.description}>
            Digite seu e-mail para receber as instruções de recuperação de senha:
          </Text>
          <View style={styles.inputContainer}>
            <Icon name="envelope" size={20} color="gray" style={styles.inputIcon} />
            <TextInput
              style={styles.input}
              placeholder="E-mail"
              onChangeText={setEmail}
              value={email}
              keyboardType="email-address"
              autoCapitalize="none"
            />
          </View>
          <TouchableOpacity style={styles.button} onPress={handlePasswordRecovery}>
            <Text style={styles.buttonText}>Recuperar Senha</Text>
          </TouchableOpacity>
        </View>
      ) : (
        <View style={styles.successContainer}>
          <Text style={styles.successMessage}>
            Um e-mail com instruções de recuperação de senha foi enviado para: {email}
          </Text>
          <TouchableOpacity style={styles.button} onPress={() => setIsEmailSent(false)}>
            <Text style={styles.buttonText}>Voltar</Text>
          </TouchableOpacity>
        </View>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingHorizontal: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  formContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    width: '80%',
  },
  successContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    width: '80%',
  },
  description: {
    fontSize: 16,
    textAlign: 'center',
    marginBottom: 20,
  },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    width: '100%',
    maxWidth: Dimensions.get('window').width * 0.8,
    borderColor: 'gray',
    borderWidth: 1,
    borderRadius: 5,
    marginBottom: 20,
    paddingHorizontal: 10,
  },
  inputIcon: {
    marginRight: 10,
  },
  input: {
    flex: 1,
    height: 40,
  },
  button: {
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    width: '100%',
    maxWidth: Dimensions.get('window').width * 0.8,
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
  successMessage: {
    fontSize: 16,
    textAlign: 'center',
    marginBottom: 20,
  },
});

export default PasswordRecoveryScreen;
