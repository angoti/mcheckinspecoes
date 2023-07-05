import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet } from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

const LoginScreen = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Lógica para autenticação do usuário
    // Aqui você pode fazer uma requisição para o backend para verificar as credenciais
  };

  const handleForgotPassword = () => {
    // Lógica para abrir outra tela de recuperação de senha
  };

  const handleGmailLogin = () => {
    // Lógica para autenticação com o Gmail
    // Aqui você pode usar uma biblioteca de autenticação do Google
  };

  return (
    <View style={styles.container}>
      <Text style={styles.logo}>MCheck Inspeções</Text>

      <View style={styles.inputView}>
        <Icon name="person" style={styles.icon} />
        <TextInput
          style={styles.inputText}
          placeholder="Usuário"
          placeholderTextColor="#003f5c"
          value={username}
          onChangeText={setUsername}
        />
      </View>

      <View style={styles.inputView}>
        <Icon name="lock" style={styles.icon} />
        <TextInput
          secureTextEntry
          style={styles.inputText}
          placeholder="Senha"
          placeholderTextColor="#003f5c"
          value={password}
          onChangeText={setPassword}
        />
      </View>

      <TouchableOpacity onPress={handleForgotPassword}>
        <Text style={styles.forgotPassword}>Esqueceu a senha?</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.loginButton} onPress={handleLogin}>
        <Text style={styles.loginText}>Entrar</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.googleButton} onPress={handleGmailLogin}>
        <Icon name="mail" style={styles.icon} />
        <Text style={styles.googleText}>Entrar com o Gmail</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  logo: {
    fontWeight: 'bold',
    fontSize: 50,
    marginBottom: 40,
    textAlign: 'center'
  },
  inputView: {
    flexDirection: 'row',
    alignItems: 'center',
    width: '80%',
    backgroundColor: 'white',
    borderRadius: 10,
    height: 50,
    marginBottom: 20,
    borderWidth: 1,
    paddingHorizontal: 10,
  },
  icon: {
    marginRight: 10,
    fontSize: 24,
    color: 'black',
  },
  inputText: {
    flex: 1,
    height: 50,
    color: 'black',
  },
  forgotPassword: {
    color: 'black',
    fontSize: 12,
  },
  loginButton: {
    width: '80%',
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginTop: 20,
    marginBottom: 10,
  },
  loginText: {
    color: 'white',
  },
  googleButton: {
    flexDirection: 'row',
    width: '80%',
    backgroundColor: '#db4a39',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: 10,
  },
  googleText: {
    color: 'white',
    marginLeft: 10,
  },
});

export default LoginScreen;
