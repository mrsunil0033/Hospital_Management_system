
                userTextField.setBounds(150, 30, 150, 30);
                userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
                userTextField.setBackground(new Color(255,179,0));
                add(userTextField);

                JLabel password = new JLabel("PASSWORD :");
                password.setFont(new Font("tahoma", Font.BOLD, 16));
                password.setBounds(40, 80, 150, 30);
                password.setForeground(Color.black);
                add(password);

                passwordTextField = new JPasswordField();
                passwordTextField.setBounds(150, 80, 150, 30);
                passwordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
                passwordTextField.setBackground(new Color(255,179,0));
                add(passwordTextField);

                login = new JButton("LOGIN");
                login.setBounds(40, 140, 120, 30);