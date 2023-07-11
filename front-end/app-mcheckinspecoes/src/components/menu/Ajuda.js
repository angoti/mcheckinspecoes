import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Modal, TextInput, Alert } from 'react-native';

const HelpScreen = () => {
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [message, setMessage] = useState('');
  const [isError, setIsError] = useState(false);
  const [isSuccess, setIsSuccess] = useState(false);

  const handleContactSupport = () => {
    setIsModalVisible(true);
  };

  const handleSubmit = () => {
    if (message.trim() === '') {
      setIsError(true);
      return;
    }

    // Lógica para enviar a mensagem para o suporte
    // Você pode chamar uma API ou implementar a lógica adequada aqui
    console.log('Mensagem enviada:', message);

    setIsSuccess(true);
    setIsModalVisible(false);
    setMessage('');
  };

  const handleCloseModal = () => {
    setIsModalVisible(false);
    setMessage('');
    setIsError(false);
    setIsSuccess(false);
  };

  const handleInputChange = (text) => {
    setMessage(text);
    setIsError(false);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Ajuda</Text>
      <Text style={styles.description}>
        Se você precisar de assistência, entre em contato com o nosso suporte técnico.
      </Text>
      <TouchableOpacity style={styles.contactButton} onPress={handleContactSupport}>
        <Text style={styles.buttonText}>Contato Suporte</Text>
      </TouchableOpacity>

      {isSuccess && <Text style={styles.successMessage}>Mensagem enviada com sucesso!</Text>}

      <Modal visible={isModalVisible} animationType="slide" transparent>
        <View style={styles.modalContainer}>
          <View style={styles.modalContent}>
            <Text style={styles.modalTitle}>Entre em Contato</Text>
            <TextInput
              style={[styles.messageInput, isError && styles.errorInput]}
              placeholder="Digite sua mensagem"
              multiline
              value={message}
              onChangeText={handleInputChange}
            />
            {isError && <Text style={styles.errorMessage}>Por favor, preencha a mensagem</Text>}
            <View style={styles.modalButtonsContainer}>
              <TouchableOpacity style={styles.modalButton} onPress={handleCloseModal}>
                <Text style={styles.modalButtonText}>Cancelar</Text>
              </TouchableOpacity>
              <TouchableOpacity style={styles.modalButton} onPress={handleSubmit}>
                <Text style={styles.modalButtonText}>Enviar</Text>
              </TouchableOpacity>
            </View>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "flex-start",
    alignItems: 'center',
    paddingHorizontal: 20,
    backgroundColor: 'white'
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    marginVertical: 40, 
    color: "#3cb371",
  },
  description: {
    fontSize: 16,
    textAlign: 'center',
    marginBottom: 40,
  },
  contactButton: {
    backgroundColor: '#3cb371',
    borderRadius: 10,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    width: '100%',
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
  modalContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
  },
  modalContent: {
    backgroundColor: 'white',
    borderRadius: 10,
    padding: 20,
    width: '80%',
  },
  modalTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 20,
    color: "#000c33",
  },
  messageInput: {
    height: 150,
    borderColor: 'gray',
    borderWidth: 1,
    borderRadius: 5,
    marginBottom: 20,
    padding: 10,
    textAlignVertical: 'top',
  },
  errorInput: {
    borderColor: 'red',
  },
  errorMessage: {
    color: 'red',
    marginBottom: 10,
  },
  successMessage: {
    color: 'green',
    marginBottom: 10,
    marginTop: 20
  },
  modalButtonsContainer: {
    flexDirection: 'row',
    justifyContent: 'flex-end',
  },
  modalButton: {
    marginLeft: 10,
  },
  modalButtonText: {
    color: '#3cb371',
    fontSize: 16,
    fontWeight: 'bold',
  },
});

export default HelpScreen;
