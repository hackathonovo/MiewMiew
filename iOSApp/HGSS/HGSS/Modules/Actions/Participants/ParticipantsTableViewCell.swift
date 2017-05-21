//
//  ParticipantsTableViewCell.swift
//  HGSS
//
//  Created by Nikola Majcen on 21/05/2017.
//  Copyright © 2017 Nikola Majcen. All rights reserved.
//

import UIKit

protocol ParticipantDelegate: class {
    func didSelected(cell: UITableViewCell)
}

class ParticipantsTableViewCell: UITableViewCell {

    @IBOutlet weak var availableButton: UIView!
    @IBOutlet weak var participantName: UILabel!
    
    fileprivate weak var _delagate: ParticipantDelegate?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    @IBAction func switchAction(_ sender: UISwitch) {
        _delagate?.didSelected(cell: self)
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func configure(with user: User, delegate: ParticipantDelegate?) {
        _delagate = delegate
        if let _first = user.firstName, let _last = user.lastName {
            participantName.text = "\(_first) \(_last)"
        } else {
            participantName.text = "Ivo Ivić"
        }
        availableButton.backgroundColor = UIColor.flatGreen
    }
}
